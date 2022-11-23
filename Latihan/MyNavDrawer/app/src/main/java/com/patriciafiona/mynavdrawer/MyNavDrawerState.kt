package com.patriciafiona.mynavdrawer

import android.content.Context
import android.widget.Toast
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MyNavDrawerState(
    val scaffoldState: ScaffoldState,
    private val scope: CoroutineScope,
    private val context: Context
) {
    fun onMenuClick() {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }


    fun onItemSelected(title: String) {
        scope.launch {
            scaffoldState.drawerState.close()
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = context.resources.getString(R.string.coming_soon, title),
                actionLabel = context.resources.getString(R.string.subscribe_question)
            )
            if (snackbarResult == SnackbarResult.ActionPerformed) {
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.subscribed_info),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    fun onBackPress() {
        if (scaffoldState.drawerState.isOpen) {
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }
}

@Composable
fun rememberMyNavDrawerState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutinesScope: CoroutineScope = rememberCoroutineScope(),
    context: Context = LocalContext.current
): MyNavDrawerState =
    remember(scaffoldState, coroutinesScope, context) {
        MyNavDrawerState(scaffoldState, coroutinesScope, context)
    }