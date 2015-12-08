package io.sphere.sdk.messages.queries;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.sphere.sdk.client.HttpRequestIntent;
import io.sphere.sdk.client.SphereRequestBase;
import io.sphere.sdk.http.HttpResponse;
import io.sphere.sdk.queries.PagedQueryResult;
import io.sphere.sdk.queries.Query;

final class TypedMessageQuery<T> extends SphereRequestBase implements Query<T> {
    private final HttpRequestIntent httpRequestIntent;
    private final JavaType resultJavaType;

    public TypedMessageQuery(final HttpRequestIntent httpRequestIntent, final JavaType elementJavaType) {
        this.httpRequestIntent = httpRequestIntent;
        final TypeFactory typeFactory = TypeFactory.defaultInstance();
        resultJavaType = typeFactory.constructParametrizedType(PagedQueryResult.class, PagedQueryResult.class, elementJavaType);
    }

    @Override
    public PagedQueryResult<T> deserialize(final HttpResponse httpResponse) {
        return deserialize(httpResponse, resultJavaType);
    }

    @Override
    public HttpRequestIntent httpRequestIntent() {
        return httpRequestIntent;
    }
}