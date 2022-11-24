package com.patriciafiona.subway.utils

sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}