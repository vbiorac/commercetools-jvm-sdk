package de.commercetools.sphere.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/** Result of a search query to the Sphere backend. */
public class SearchResult<T> {
    private int offset;
    private int count;
    private int total;
    private List<T> results;
    @JsonProperty("facets")
    private Map<String, FacetResult> facets;

    public SearchResult(int offset, int count, int total, Collection<T> results, Map<String, FacetResult> facets) {
        this.offset = offset;
        this.count = count;
        this.total = total;
        this.results = new ArrayList<T>(results);
        this.facets = facets;
    }

    // for JSON deserializer
    private SearchResult() { }

    /** Gets a terms facet result for a facet requested using
     * {@link de.commercetools.sphere.client.util.SearchRequestBuilder#facet}. */
    public TermsFacetResult getTermsFacet(String expression) {
        return (TermsFacetResult)facets.get(expression);
    }

    /** Gets a number range facet result for a facet requested using
     * {@link de.commercetools.sphere.client.util.SearchRequestBuilder#facetDoubleRanges}. */
    public RangeFacetResult getRangeFacet(String expression) {
        return (RangeFacetResult)facets.get(expression);
    }

    /** Gets a date range facet result for a facet requested using
     * {@link de.commercetools.sphere.client.util.SearchRequestBuilder#facetDateRanges}. */
    public DateRangeFacetResult getDateRangeFacet(String expression) {
        // Search returns Date facet ranges in milliseconds
        return DateRangeFacetResult.fromMilliseconds(getRangeFacet(expression));
    }

    // TODO time
    // TODO datetime

    // TODO value facets

    public int getOffset() {
        return offset;
    }
    public int getCount() {
        return count;
    }
    public int getTotal() {
        return total;
    }
    public List<T> getResults() {
        return results;
    }
}
