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

    3.3 eureka.client
    3.4 dashboard