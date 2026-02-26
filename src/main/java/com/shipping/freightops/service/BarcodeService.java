package com.shipping.freightops.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class BarcodeService {
  public byte[] generateBarcode(String content, int width, int height) {
    try {
      if (content == null || content.isBlank()) {
          throw new IllegalArgumentException("Content must not be null or blank");
      }
      if (width <= 0 || height <= 0) {
          throw new IllegalArgumentException("Width and height must be positive");
      }
      BitMatrix bitMatrix =
          new MultiFormatWriter().encode(content, BarcodeFormat.CODE_128, width, height);

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

      return outputStream.toByteArray();
    } catch (WriterException | IOException e) {
      throw new RuntimeException("Failed to generate barcode", e);
    }
  }

  public byte[] generateQrCode(String content, int width, int height) {
    try {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content must not be null or blank");
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
      BitMatrix bitMatrix =
          new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

      return outputStream.toByteArray();
    } catch (WriterException | IOException e) {
      throw new RuntimeException("Failed to generate QR code", e);
    }
  }
}
