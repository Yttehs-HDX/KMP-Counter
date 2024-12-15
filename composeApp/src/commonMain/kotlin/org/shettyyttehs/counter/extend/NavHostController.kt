/**
 * Extension functions for NavHostController
 */

package org.shettyyttehs.counter.extend

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions

fun NavHostController.navigateSingleTop(route: String) {
    val navOptions = NavOptions.Builder()
        .setLaunchSingleTop(true)
        .build()
    navigate(route, navOptions)
}