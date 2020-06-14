package com.ccsu.shuziyingxin.common;

import com.hankcs.hanlp.corpus.io.IIOAdapter;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-06-06 15:59
 */
public class ResourceFileIOAdapter implements IIOAdapter {
    @Override
    public InputStream open(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource( path );
        InputStream is = new FileInputStream( resource.getFile() );
        return is;
    }

    @Override
    public OutputStream create(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource( path );
        OutputStream os = new FileOutputStream( resource.getFile() );
        return os;
    }
}