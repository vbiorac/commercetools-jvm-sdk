package io.sphere.sdk.client;

import io.sphere.sdk.requests.ClientRequest;

import java.util.concurrent.CompletableFuture;

public interface JavaClient extends AutoCloseable {
    <T> CompletableFuture<T> execute(final ClientRequest<T> clientRequest);

    void close();
}
