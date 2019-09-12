package com.company;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;

public class PublicKeyLoader {

    public PublicKey getKey(String path) throws Exception {

        // Ładujemy do pamięci plik certyfikatu
        InputStream certificateFile = new FileInputStream(path);

        // Tworzymy instancję fabryki, która da nam klucz publiczny
        CertificateFactory factory = CertificateFactory.getInstance("X.509");

        // Wyciągamy klucz publiczny z certyfikatu
        return factory.generateCertificate(certificateFile).getPublicKey();
    }
}
