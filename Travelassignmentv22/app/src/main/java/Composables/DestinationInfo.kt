
package com.kranthi.Travelassignmentv2.Composables
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.kranthi.Travelassignmentv2.Destination
import com.kranthi.Travelassignmentv2.JourneyColor

@Composable
fun DestinationInfo(destination: Destination) {

    Column {

        Text(
            text = destination.city,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = JourneyColor.DarkGreen
        )

        Text(
            text = destination.country,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Highlight: ${destination.landmark}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium

        )
    }
}
