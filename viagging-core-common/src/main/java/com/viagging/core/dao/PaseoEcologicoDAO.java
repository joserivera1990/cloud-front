package com.viagging.core.dao;

import com.viagging.core.model.PaseoEcologico;

public interface PaseoEcologicoDAO {
   
	PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico);

	PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico);

	PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico);

	PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico);
}
