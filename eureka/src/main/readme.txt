1. 服务注册中心
2. 单节点 / 多节点高可用
3. 配置说明
    3.1 实例配置
        以eureka.instance为开头的配置,可以通过org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean的源码获取详细的配置信息.
      其中大部分都是对服务实例元数据的配置,它是eureka客户端在向服务注册中心发送注册请求时,用来描述自身实例信息的对象,其中包含了一些标准化的元数据,比如
      服务名称,实例名称,实例IP,实例端口等用于服务治理的重要信息,以及一些用于负载均衡策略或是其他特殊用途的自定义元数据信息.
      下面是几个配置的简要说明: (eureka.instance.)
      namespace: 配置属性的命名空间
      appname: 应用名 默认取spring.application.name (如果存在,否则为unknown)
      hostname: 服务主机名称 (默认取操作系统的主机名)
      ipAddress: 实例的ip地址
      instanceId: 注册到eureka上的唯一实例ID (vcap.application.instance_id / hostname:appname:spring.application.instance_id / hostname:appname:port)
      nonSecurePort: 非安全的端口(80)
      nonSecurePortEnabled: 非安全端口启用
      securePortEnabled: 安全端口启用
      preferIpAddress: 是否优先使用ip地址作为主机名的标识
      leaseRenewalIntervalInSeconds: *一般为客户端设置* eureka客户端向服务端发送心跳的时间间隔,单位为秒 (默认为30s)
      leaseExpirationDurationInSeconds: *一般为服务端设置* eureka服务端在收到最后一次心跳之后等待的时间上限,单位为秒.
                                        超过该时间之后服务端会将该服务实例从服务清单中剔除,从而禁止服务调用请求被发送到该实例上.
      几个url:
        statusPageUrlPath: 实例状态页相对路径 (/actuator/info)
        statusPageUrl: 实例状态页绝对路径
        homePageUrlPath; 实例主页相对路径 (/actuator/)
        homePageUrl
        healthCheckUrlPath: 实例健康检查页相对路径 (/actuator/health)
        healthCheckUrl
        secureHealthCheckUrl

    3.2 eureka.server
        以eureka.server开头的相关配置,主要是服务注册中心的相关配置.
      enableSelfPreservation: 是否开启自我保护,默认为true. Eureka会统计15分钟之内心跳失败的比例占总心跳的比例低于自我保护续约百分比阈值因子,
                                将会触发保护机制,不剔除服务提供者,如果关闭则服务注册中心将不可用的实例正确剔除.
      renewalPercentThreshold: 自我保护续约百分比阀值因子.如果实际续约(心跳)数小于续约数阀值,则开启自我保护. 默认0.85.
      renewalThresholdUpdateIntervalMs: 续约数阀值更新频率.

    3.3 eureka.client
        以eureka.client开头相关的配置,服务注册相关的配置信息,包括服务注册中心的地址,服务获取的间隔时间,可用区域等.
      enabled: 启用eureka客户端,默认为true
      serviceUrl.defaultZone: 注册到指定的服务注册中心的url
      fetchRegistry: 是否从eureka服务端获取注册信息.
      registerFetchIntervalSeconds: 从eureka服务端获取注册信息的间隔时间,单位为秒,默认为30s
      registerWithEureka: 是否要将自身的实例信息注册到eureka服务端. 默认为true
      执行心跳续约使用的线程池的配置:
      heartbeatExecutorThreadPoolSize: 心跳连接池的初始化线程数. 默认为2
      heartbeatExecutorExponentialBackOffBound: 心跳超时重试延迟时间的最大乘数值. 默认为10

      initialInstanceInfoReplicationIntervalSeconds: 初始化实例信息到eureka服务端的间隔时间,单位为秒,默认值为40s
      instanceInfoReplicationIntervalSeconds: 更新实例信息的变化到eureka服务端的间隔时间,单位为秒,默认值为30s
      eurekaServiceUrlPollIntervalSeconds: 轮询Eureka服务端地址更改的间隔时间,单位为秒.当我们与Spring Cloud Config配合,动态刷新Eureka
                                           的serviceUrl地址时需要关注该参数.
      eurekaServerReadTimeoutSeconds: 读取eureka server信息的超时时间,单位为秒.默认值为8s
      eurekaServerConnectTimeoutSeconds: 连接eureka server的超时时间,单位为秒.默认值为5s
      eurekaServerTotalConnections: 从eureka客户端到所有eureka服务端的连接总数,默认值为200
      eurekaServerTotalConnectionsPerHost: 从eureka客户端到每个eureka服务端主机的连接总数. 默认为50
      eurekaConnectionIdleTimeoutSeconds: eureka服务端连接的空闲关闭时间,单位为秒.默认值为30

      cacheRefreshExecutorThreadPoolSize: 缓存刷新线程池的初始化线程数. 默认为2
      cacheRefreshExecutorExponentialBackOffBound: 缓存刷新重试延迟时间的最大乘数值. 默认为10

      useDnsForFetchingServiceUrls: 使用DNS来获取eureka服务端的serviceUrl. 默认false
      preferSameZoneEureka: 是否偏好使用处于相同zone的eureka服务端. 默认为true
      filterOnlyUpInstances: 获取实例时是否过滤,仅保留UP状态的实例.

    3.4 dashboard