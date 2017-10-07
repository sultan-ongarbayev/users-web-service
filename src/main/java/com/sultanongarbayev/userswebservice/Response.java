package com.sultanongarbayev.userswebservice;

/**
 * Response is the class which represents any response to the client which has no data except for meta information.
 */
public class Response {

    /**
     * Response code.
     */
    private int responseCode;

    /**
     * Message of the response.
     */
    private String message;

    public Response(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public Response() {
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseCode=" + responseCode +
                ", message='" + message + '\'' +
                '}';
    }
}
