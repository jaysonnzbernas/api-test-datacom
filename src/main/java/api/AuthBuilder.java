package api;

import lombok.Builder;

@Builder
public class AuthBuilder {

    private String consumer_key;
    private String token;
    private String signature_method;
    private String signature;

    @Override
    public String toString(){
        return """
                OAuth oauth_consumer_key=%s,oauth_token=%s,oauth_signature_method=%s,oauth_signature=%s
                """.formatted(consumer_key, token, signature_method, signature);
    }
}
