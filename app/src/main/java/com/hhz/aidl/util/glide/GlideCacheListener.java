package com.hhz.aidl.util.glide;

public interface GlideCacheListener {

    void success(String path);

    void error(Exception e);
}
