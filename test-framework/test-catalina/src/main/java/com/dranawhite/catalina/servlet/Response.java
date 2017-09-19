package com.dranawhite.catalina.servlet;

import com.dranawhite.catalina.BaseResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response extends BaseResponse implements ServletResponse {

    private PrintWriter writer;

    public Response(OutputStream output) {
        super(output);
    }

    /**
     * implementation of ServletResponse
     */
    public void flushBuffer() throws IOException {
    }

    public int getBufferSize() {
        return 0;
    }

    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    public Locale getLocale() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        // autoflush is true, println() will flush,
        // but print() will not.
        writer = new PrintWriter(getOutput(), true);
        return writer;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {
    }

    public void resetBuffer() {
    }

    public void setBufferSize(int size) {
    }

    public void setContentLength(int length) {
    }

    @Override
    public void setContentLengthLong(long len) {

    }

    public void setContentType(String type) {
    }

    public void setLocale(Locale locale) {
    }
}