package com.redislabs.lettusearch.search.api.reactive;

import java.util.List;
import java.util.Map;

import com.redislabs.lettusearch.aggregate.AggregateOptions;
import com.redislabs.lettusearch.aggregate.AggregateResults;
import com.redislabs.lettusearch.aggregate.AggregateWithCursorResults;
import com.redislabs.lettusearch.aggregate.CursorOptions;
import com.redislabs.lettusearch.search.AddOptions;
import com.redislabs.lettusearch.search.DropOptions;
import com.redislabs.lettusearch.search.Schema;
import com.redislabs.lettusearch.search.SearchOptions;
import com.redislabs.lettusearch.search.SearchResults;
import com.redislabs.lettusearch.search.field.FieldOptions;

import io.lettuce.core.api.reactive.RedisReactiveCommands;
import reactor.core.publisher.Mono;

public interface SearchReactiveCommands<K, V> extends RedisReactiveCommands<K, V> {

	Mono<String> create(String index, Schema schema);

	Mono<String> drop(String index, DropOptions options);

	Mono<List<Object>> indexInfo(String index);

	Mono<String> alter(String index, K field, FieldOptions options);

	Mono<String> add(String index, K docId, double score, Map<K, V> fields);

	Mono<String> add(String index, K docId, double score, Map<K, V> fields, AddOptions options);

	Mono<String> add(String index, K docId, double score, Map<K, V> fields, AddOptions options, V payload);

	Mono<SearchResults<K, V>> search(String index, String query, SearchOptions options);

	Mono<Map<K, V>> get(String index, K docId);

	Mono<Boolean> del(String index, K docId, boolean deleteDoc);

	Mono<AggregateResults<K, V>> aggregate(String index, String query, AggregateOptions options);

	Mono<AggregateWithCursorResults<K, V>> aggregate(String index, String query, AggregateOptions options,
			CursorOptions cursorOptions);

	Mono<AggregateWithCursorResults<K, V>> cursorRead(String index, long cursor);

	Mono<AggregateWithCursorResults<K, V>> cursorRead(String index, long cursor, long count);

	Mono<String> cursorDelete(String index, long cursor);

	Mono<String> aliasAdd(String name, String index);

	Mono<String> aliasUpdate(String name, String index);

	Mono<String> aliasDel(String name);

	Mono<String> alterAliasDel(String index, String alias);

}