package com.company;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;

public class KeystoreLoader {

    private KeyStore keystore;

    public void load(String path, String password) throws Exception {

        // Ładujemy do pamięci plik repozytorium
        InputStream keyStoreFile = new FileInputStream(path);

        // Tworzymy nową instancę w formacie naszego repozytorium
        keystore = KeyStore.getInstance("JKS");

        // Otwieramy repozytorium podając hasło
        keystore.load(keyStoreFile, password.toCharArray());
    }

    public KeyPair getKeyPair(String alias, String password) throws Exception {

        // Pobieramy klucz prywanty z repozytorium (wymagane jest hasło)
        Key key = keystore.getKey(alias, password.toCharArray());

        // Tworzymy certyfikat klucza publicznego
        Certificate certificate = keystore.getCertificate(alias);

        // Finalnie tworzymy obiekt pary klucza prywatnego i publicznego
        return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
    }

}
