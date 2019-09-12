package com.company;

import java.security.KeyPair;

public class Main {

    public static void main(String[] args) {
        String path = "artykul.jks";
        String keystore_pass = "#xp8!cuhHQuVUoZj";

        String key_name = "artykul_o_kluczach";
        String key_pass = "jZoUVuQHhuc!8px#";
        try {
            KeystoreLoader loader = new KeystoreLoader();
            loader.load(path, keystore_pass);
            KeyPair keyPair = loader.getKeyPair(key_name, key_pass);
            System.out.println("private: " + keyPair.getPrivate());
            System.out.println("public: " + keyPair.getPublic());
        } catch (Exception e) {
            e.printStackTrace();
        }

        path = "certyfikat.cer";

        try {
            PublicKeyLoader loader = new PublicKeyLoader();
            System.out.println("pub z certyfikatu: " + loader.getKey(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
