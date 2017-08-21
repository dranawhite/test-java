package com.dranawhite.frame.proxy;

/**
 * 代理接口
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public interface Proxy {

    /**
     * 执行链式代理
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
