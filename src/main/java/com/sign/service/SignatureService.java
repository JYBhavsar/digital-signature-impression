package com.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sign.util.CryptoUtil;

@Service
public class SignatureService {

    @Autowired
    private CryptoUtil cryptoUtil;

    public String generateRSASignature(byte[] data) throws Exception {
        return cryptoUtil.signDataRSA(data);
    }

    public boolean verifyRSASignature(byte[] data, String signature) throws Exception {
        return cryptoUtil.verifyDataRSA(data, signature);
    }

    public String generateECCSignature(byte[] data) throws Exception {
        return cryptoUtil.signDataECC(data);
    }

    public boolean verifyECCSignature(byte[] data, String signature) throws Exception {
        return cryptoUtil.verifyDataECC(data, signature);
    }
}