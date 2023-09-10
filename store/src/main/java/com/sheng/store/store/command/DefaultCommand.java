package com.sheng.store.store.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class DefaultCommand extends HystrixCommand<String> {

    public DefaultCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return null;
    }

    @Override
    protected String getFallback() {
        return super.getFallback();
    }

    public static void main(String[] args) {
        DefaultCommand defaultCommand = new DefaultCommand(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test")));
        defaultCommand.execute();
    }

}
