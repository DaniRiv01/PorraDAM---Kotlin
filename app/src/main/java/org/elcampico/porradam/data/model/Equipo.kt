package org.elcampico.porradam.data.model

import androidx.annotation.DrawableRes

data class Equipo(
    val id: String,
    val nombre: String,
    val siglas: String,
    val colorHex: Long,
    @param:DrawableRes val imagenResId: Int? = null
)
