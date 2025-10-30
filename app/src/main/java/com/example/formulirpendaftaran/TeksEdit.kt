package com.example.formulirpendaftaran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D47A1),
                        Color(0xFF5472D3)
                    )
                )
            )
            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Formulir Pendaftaran",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_small))
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                // Nama Lengkap
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    label = { Text(text = "Nama Lengkap") },
                    placeholder = { Text("Isian nama lengkap") },
                    onValueChange = { textNama = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "JENIS KELAMIN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                gender.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            .padding(start = 8.dp)
                    ) {
                        RadioButton(selected = textJK == item, onClick = { textJK = item })
                        Text(text = item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "STATUS PERKAWINAN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                statusList.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            .padding(start = 8.dp)
                    ) {
                        RadioButton(selected = textStatus == item, onClick = { textStatus = item })
                        Text(text = item)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    label = { Text(text = "Alamat") },
                    placeholder = { Text("Alamat") },
                    onValueChange = { textAlamat = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1)),
                    enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
                    onClick = {
                        nama = textNama
                        jenis = textJK
                        status = textStatus
                        alamat = textAlamat
                    }
                ) {
                    Text(text = stringResource(R.string.submit), color = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (nama.isNotEmpty()) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0D47A1)),
                modifier = Modifier
                    .width(300.dp)
                    .height(130.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
                ) {
                    Text(text = "Nama : "+nama, color = Color.White)
                    Text(text = "Gender : "+jenis, color = Color.White)
                    Text(text = "Status : "+status, color = Color.White)
                    Text(text = "Alamat : "+alamat, color = Color.White)
                }
            }
        }
    }
}