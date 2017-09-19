package com.dranawhite.catalina.socket;

import com.dranawhite.catalina.BaseRequest;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author dranawhite 2017/9/18
 * @version 1.0
 */
public class Request extends BaseRequest {

    public Request(InputStream input) {
        super(input);
    }

}
