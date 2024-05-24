package com.example.marvel_app.ui

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "phone",
    device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480",
    showBackground = true
)
@Preview(name = "nexus 5", device = Devices.NEXUS_5, showBackground = true)
@Preview(name = "pixel 7a", device = Devices.PIXEL_7A, showBackground = true)
@Preview(
    name = "tablet",
    device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480",
    showBackground = true
)
annotation class DevicePreviews