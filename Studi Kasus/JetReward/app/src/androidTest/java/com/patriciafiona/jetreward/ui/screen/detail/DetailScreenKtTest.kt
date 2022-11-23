package com.patriciafiona.jetreward.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.patriciafiona.jetreward.model.OrderReward
import com.patriciafiona.jetreward.model.Reward
import com.patriciafiona.jetreward.ui.theme.JetRewardTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import com.patriciafiona.jetreward.R
import com.patriciafiona.jetreward.onNodeWithStringId
import org.junit.Test

class DetailContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(4, R.drawable.reward_4, "Jaket Hoodie Dicoding", 7500),
        count = 0
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetRewardTheme {
                DetailContent(
                    fakeOrderReward.reward.image,
                    fakeOrderReward.reward.title,
                    fakeOrderReward.reward.requiredPoint,
                    fakeOrderReward.count,
                    onBackClick = {},
                    onAddToCart = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailContent_isDisplayed() {
        composeTestRule.onNodeWithText(fakeOrderReward.reward.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.required_point,
                fakeOrderReward.reward.requiredPoint
            )
        ).assertIsDisplayed()
    }

    @Test
    fun increaseProduct_buttonEnabled() {
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsNotEnabled()
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick()
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsEnabled()
    }

    @Test
    fun increaseProduct_correctCounter() {
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick().performClick()
        composeTestRule.onNodeWithTag("count").assert(hasText("2"))
    }

    @Test
    fun decreaseProduct_stillZero() {
        composeTestRule.onNodeWithStringId(R.string.minus_symbol).performClick()
        composeTestRule.onNodeWithTag("count").assert(hasText("0"))
    }
}