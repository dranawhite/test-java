package com.dranawhite.catalina.socket;

import com.dranawhite.catalina.BaseResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author dranawhite 2017/9/18
 * @version 1.0
 */
public class Response extends BaseResponse {

    public Response(OutputStream output) {
        super(output);
    }

}
