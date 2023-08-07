package com.example.dashboard_v1.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dashboard_v1.R
import com.example.dashboard_v1.components.CreateChannelNotification
import com.example.dashboard_v1.components.notificacionExtensa
import com.example.dashboard_v1.components.notificacionImagen
import com.example.dashboard_v1.components.notificacionProgramada
import com.example.dashboard_v1.components.notificacionSencilla

@Composable
fun Page_Informacion() {
    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idchannel: String = stringResource(R.string.canal_Tienda)
    val name = stringResource(R.string.canal_Tienda)
    val descriptionText= stringResource(R.string.canal_Notifi)

    val textShort: String = "Ejemplo de notificación sencilla con prioridad de omisión (default)"
    val textLong: String = "Saludos! Esta es una prueba de notificaciones. Debe aparecer " +
                            "un icono a la derecha y el texto puede tener una longitud de 200 caracteres. " +
                            "El tamaño de la notificacion puede colapsar y/o expandirse " +
                            "Gracias y hasta pronto"
    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_contact_mail_black_48dp
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    LaunchedEffect(Unit){
        CreateChannelNotification(
            idchannel,
            context,
            name,
            descriptionText
        )
    }

    val modifier = Modifier
        .padding(18.dp)
        .fillMaxWidth()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(18.dp)
            .fillMaxSize()
    ) {
        Text(

            text = "Información de Notificaciones",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(bottom = 100.dp)
                .width(300.dp)
        )
        Button(
            onClick = {
                notificacionSencilla(
                    context,
                    idchannel,
                    idNotification,
                    "Notificacion Sencilla",
                    textShort
                )
            },
            modifier = modifier
        ) {
            Text(
                text = "Notificaciones Sencillas"
            )
        }
        Button(
            onClick = {
                notificacionExtensa(
                    context,
                    idchannel,
                    idNotification + 1,
                    "Notifiación Extensa",
                    textLong,
                    iconoBig
                )
            },
            modifier = modifier
        ) {
            Text(
                text = "Notificaciones Extensas"
            )
        }
        Button(
            onClick = {
                notificacionImagen(
                    context,
                    idchannel,
                    idNotification + 2,
                    "Notificación con Imagen",
                    textLong,
                    iconoBig,
                    imagenBig
                )
            },
            modifier = modifier
        ) {
                Text(
                    text = "Notificaciones con Imagen"
                )
        }
        Button(
            onClick = {
                notificacionProgramada(
                    context
                )
            },
            modifier = modifier
        ) {
            Text(
                text = "Notificaciones Programadas"
            )
        }
    }
}