package com.sheng.user.configuration;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import java.util.List;
import java.util.function.Predicate;

public abstract class EnableCustomImportSelector<T> implements ImportSelector, BeanClassLoaderAware, EnvironmentAware {

    private ClassLoader beanClassLoader;

    private Environment environment;

    private Class<?> annotationClass = GenericTypeResolver.resolveTypeArgument(this.getClass(), EnableCustomImportSelector.class);

    @Override
    public String[] selectImports(AnnotationMetadata importingClass) {
        List<String> importClass = SpringFactoriesLoader.loadFactoryNames(annotationClass, this.beanClassLoader);
        return importClass.toArray(String[]::new);
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }
}
