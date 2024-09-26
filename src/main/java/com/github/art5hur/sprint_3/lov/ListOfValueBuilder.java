package com.github.art5hur.sprint_3.lov;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.github.art5hur.sprint_3.repository.CargoRepository;
import com.github.art5hur.sprint_3.repository.DepartamentoRepository;

@Component
public class ListOfValueBuilder {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private CargoRepository cargoRepository;

	public List<ListOfValue> getLovDepartamentos() {			
		return departamentoRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(d -> new ListOfValue(d.getId(), d.getNome()))
				.toList();
	}

	public List<ListOfValue> getLovCargos() {
		return cargoRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(c -> new ListOfValue(c.getId(), c.getNome()))
				.toList();
	}
	
	public List<String> getLovAreas() {
        return Arrays.asList("Farmacêutica", "Gestão", "Tecnologia", "Qualidade", "Logística");
    }

}
