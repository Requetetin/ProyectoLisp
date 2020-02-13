(deftemplate situacion-persona
		(slot dificultadCarrera)
		(slot horarioClases)
		(slot cargaTrabajo)
		(multislot horasEstudioSemanal))

(defrule psico-0
	(situacion-persona
		(dificultadCarrera facil)
		(horarioClases tarde)
		(cargaTrabajo leve)
		(horasEstudioSemanal < 5))
	=> (printout t crlf "Esudia psicologia -> Solo ponele ganas al final del semestre" crlf crlf))

(defrule psico-1
	(situacion-persona
		(dificultadCarrera facil)
		(horarioClases noche)
		(cargaTrabajo leve)
		(horasEstudioSemanal < 5))
	=> (printout t crlf "Esudia psicologia (Te recomendamos en la tarde) -> Solo ponele ganas al final del semestre" crlf crlf))

(defrule psico-2
	(situacion-persona
		(dificultadCarrera facil)
		(horarioClases tarde)
		(cargaTrabajo leve)
		(horasEstudioSemanal > 5))
	=> (printout t crlf "Esudia psicologia-> Ganas facil" crlf crlf))

(defrule psico-3
	(situacion-persona
		(dificultadCarrera facil)
		(horarioClases noche)
		(cargaTrabajo leve)
		(horasEstudioSemanal > 5))
	=> (printout t crlf "Esudia psicologia (Te recomendamos en la tarde) -> Ganas facil" crlf crlf))


(defrule medicina-0
	(situacion-persona
		(dificultadCarrera dificil)
		(horarioClases manana)
		(cargaTrabajo alta)
		(horasEstudioSemanal > 5))
	=> (printout t crlf "Esudia medicina -> Te va a costar pasar el semestre" crlf crlf))

(defrule medicina-1
	(situacion-persona
		(dificultadCarrera dificil)
		(horarioClases manana)
		(cargaTrabajo alta)
		(horasEstudioSemanal < 5))
	=> (printout t crlf "Esudia medicina -> No vas a pasar el semestre" crlf crlf))

(defrule compu-0
	(situacion-persona
		(dificultadCarrera intermedio)
		(horarioClases manana)
		(cargaTrabajo medio)
		(horasEstudioSemanal < 5))
	=> (printout t crlf "Esudia Ciencias de la computacion-> Te va a costar el semestre" crlf crlf))

(defrule compu-1
	(situacion-persona
		(dificultadCarrera dificil)
		(horarioClases manana)
		(cargaTrabajo medio)
		(horasEstudioSemanal < 5))
	=> (printout t crlf "Esudia Ciencias de la computacion-> Te va a costar el semestre" crlf crlf))

(defrule compu-2
	(situacion-persona
		(dificultadCarrera intermedio)
		(horarioClases noche)
		(cargaTrabajo medio)
		(horasEstudioSemanal > 5))
	=> (printout t crlf "Esudia Ciencias de la computacion-> Te va a costar el semestre" crlf crlf))

(defrule compu-3
	(situacion-persona
		(dificultadCarrera dificil)
		(horarioClases noche)
		(cargaTrabajo medio)
		(horasEstudioSemanal > 5))
	=> (printout t crlf "Esudia Ciencias de la computacion-> Te va a costar el semestre" crlf crlf))
