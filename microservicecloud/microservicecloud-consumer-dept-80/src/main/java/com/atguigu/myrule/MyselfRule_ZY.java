package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyselfRule_ZY extends AbstractLoadBalancerRule {

    private int total;
    private int currentIndex;

    /**
     * 三个微服务，每个调用五次之后切换微服务
     *
     * @param lb
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key) {

        Server server = null;
        if (lb == null) {
            return null;
        } else {
            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
//                int serverCount = allList.size();
//                if (serverCount == 0) {
//                    return null;
//                }
//
//                int index = this.rand.nextInt(serverCount);
//                server = (Server)upList.get(index);
                if (total < 5) {
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total=0;
                    currentIndex++;
                    if (currentIndex>=upList.size()){
                        currentIndex=0;
                    }
                }
            }

            if (server == null) {
                Thread.yield();
            } else {
                if (server.isAlive()) {
                    return server;
                }

                server = null;
                Thread.yield();
            }
        }

        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return null;
    }
}
