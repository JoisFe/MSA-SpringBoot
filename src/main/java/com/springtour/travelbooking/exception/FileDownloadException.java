package com.springtour.travelbooking.exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class FileDownloadException extends RuntimeException {

    public FileDownloadException() {
        super();
    }

    public FileDownloadException(String message) {
        super(message);
    }

    public FileDownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDownloadException(Throwable cause) {
        super(cause);
    }

    public FileDownloadException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
