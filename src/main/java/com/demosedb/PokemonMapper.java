package com.demosedb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.helidon.dbclient.DbColumn;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.DbRow;

/**
 * Maps database statements to {@link com.demosedb.Pokemon} class.
 */
public class PokemonMapper implements DbMapper<Pokemon> {

	@Override
	public Pokemon read(DbRow row) {
		DbColumn id = row.column("id");
		DbColumn name = row.column("name");
		DbColumn type = row.column("idType");
		return new Pokemon(id.get(Integer.class), name.get(String.class), type.get(Integer.class));
	}

	@Override
	public Map<String, ?> toNamedParameters(Pokemon value) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", value.id());
		map.put("name",value.name());
		map.put("idType", value.idType());
		return map;
	}

	@Override
	public List<?> toIndexedParameters(Pokemon value) {
		List<Object> list = new ArrayList<Object>();
		list.add(value.id());
		list.add(value.name());
		list.add(value.idType());
		return list;
	}
}
