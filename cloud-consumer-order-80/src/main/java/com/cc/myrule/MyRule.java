package com.cc.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @author: cc
 * @Date: 2020/10/16 0016 17:17
 * @Description:
 */
public class MyRule extends AbstractLoadBalancerRule {


    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    public Server choose(Object key) {
        return null;
    }
}
