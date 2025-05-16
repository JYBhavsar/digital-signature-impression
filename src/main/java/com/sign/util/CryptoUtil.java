package com.sign.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

@Component
public class CryptoUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private KeyPair rsaKeyPair;
    private KeyPair eccKeyPair;

    public CryptoUtil() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        this.rsaKeyPair = generateRSAKeyPair();
        this.eccKeyPair = generateECCKeyPair();
    }

    // Generate RSA 2048-bit key pair
    private KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    // Generate ECC P-256 key pair
    private KeyPair generateECCKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
        keyGen.initialize(ecSpec);
        return keyGen.generateKeyPair();
    }

    // Sign data with RSA private key (SHA256withRSA)
    public String signDataRSA(byte[] data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(rsaKeyPair.getPrivate());
        signature.update(data);
        byte[] signedBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    // Verify RSA signature
    public boolean verifyDataRSA(byte[] data, String base64Signature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(rsaKeyPair.getPublic());
        signature.update(data);
        byte[] decodedSig = Base64.getDecoder().decode(base64Signature);
        return signature.verify(decodedSig);
    }

    // Sign data with ECC private key (SHA256withECDSA)
    public String signDataECC(byte[] data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
        signature.initSign(eccKeyPair.getPrivate());
        signature.update(data);
        byte[] signedBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    // Verify ECC signature
    public boolean verifyDataECC(byte[] data, String base64Signature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
        signature.initVerify(eccKeyPair.getPublic());
        signature.update(data);
        byte[] decodedSig = Base64.getDecoder().decode(base64Signature);
        return signature.verify(decodedSig);
    }

    // Getter for public keys (Base64 encoded) for sharing or verification purpose
    public String getRSAPublicKey() {
        return Base64.getEncoder().encodeToString(rsaKeyPair.getPublic().getEncoded());
    }

    public String getECCPublicKey() {
        return Base64.getEncoder().encodeToString(eccKeyPair.getPublic().getEncoded());
    }
}
