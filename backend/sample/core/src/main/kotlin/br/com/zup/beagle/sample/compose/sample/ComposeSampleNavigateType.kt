/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.sample.compose.sample

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.sample.constants.BUTTON_STYLE_APPEARANCE
import br.com.zup.beagle.sample.constants.CYAN_BLUE
import br.com.zup.beagle.sample.constants.CYAN_GREEN
import br.com.zup.beagle.sample.constants.LIGHT_ORANGE
import br.com.zup.beagle.sample.constants.LIGHT_RED
import br.com.zup.beagle.sample.constants.NAVIGATION_TYPE_ENDPOINT
import br.com.zup.beagle.sample.constants.QAFLAG_PLACEHOLDER
import br.com.zup.beagle.sample.constants.RED
import br.com.zup.beagle.sample.constants.RED_ORANGE
import br.com.zup.beagle.sample.constants.REPRESENTATION_NAVIGATION_TYPE_STEP2_ENDPOINT
import br.com.zup.beagle.sample.constants.REPRESENTATION_NAVIGATION_TYPE_STEP3_ENDPOINT
import br.com.zup.beagle.sample.constants.REPRESENTATION_PRESENT_ENDPOINT
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button

object ComposeSampleNavigateType: ComposeComponent {
    const val QA_FLAG_FALSE = "false"
    override fun build() = Container(
        children = listOf(
            buttonPopView,
            createButton(
                text = "PushView (Step 2)",
                navigate = Navigate.PushView(
                    Route.Remote(
                        REPRESENTATION_NAVIGATION_TYPE_STEP2_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE)
                    )
                ),
                backgroundColor = LIGHT_RED
            )
        )
    )

    private val buttonPopView = createButton(
        text = "PopView",
        navigate = Navigate.PopView(),
        backgroundColor = CYAN_BLUE
    )

    private val buttonAddViewStep1 = createButton(
        text = "PushView (Step 1)",
        navigate = Navigate.PushView(
            Route.Remote(NAVIGATION_TYPE_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE))
        ),
        backgroundColor = LIGHT_RED
    )

    fun step2() = Screen(
        navigationBar = NavigationBar(
            title = "Step 2",
            showBackButton = true
        ),
        child = Container(
            children = listOf(
                buttonPopView,
                createButton(
                    text = "PushView (Step 3)",
                    navigate = Navigate.PushView(
                        Route.Remote(
                            REPRESENTATION_NAVIGATION_TYPE_STEP3_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE)
                        )
                    ),
                    backgroundColor = LIGHT_RED
                ),
                createButton(
                    text = "PushStack",
                    navigate = Navigate.PushStack(
                        Route.Remote(REPRESENTATION_PRESENT_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE))
                    ),
                    backgroundColor = LIGHT_ORANGE
                )
            )
        )
    )

    fun presentView() = Screen(
        navigationBar = NavigationBar(
            title = "Present",
            showBackButton = true
        ),
        child = Container(
            children = listOf(
                buttonPopView,
                buttonAddViewStep1,
                createButton(
                    text = "PopStack",
                    navigate = Navigate.PopStack(),
                    backgroundColor = CYAN_GREEN
                )
            )
        )
    )

    fun step3() = Screen(
        navigationBar = NavigationBar(
            title = "Step 3",
            showBackButton = true
        ),
        child = Container(
            children = listOf(
                buttonPopView,
                createButton(
                    text = "ResetApplication (Step 1)",
                    navigate = Navigate.ResetApplication(
                        Route.Remote(NAVIGATION_TYPE_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE))
                    ),
                    backgroundColor = RED_ORANGE
                ),
                createButton(
                    text = "PopToView (Step 1)",
                    navigate = Navigate.PopToView(
                        NAVIGATION_TYPE_ENDPOINT.replace(QAFLAG_PLACEHOLDER, QA_FLAG_FALSE)
                    ),
                    backgroundColor = RED
                ),
                buttonAddViewStep1
            )
        )
    )

    private fun createButton(text: String, navigate: Navigate, backgroundColor: String) =
        Button(
            text = text,
            styleId = BUTTON_STYLE_APPEARANCE,
            onPress = listOf(navigate)
        ).applyStyle(
            Style(
                backgroundColor = backgroundColor,
                cornerRadius = CornerRadius(radius = 10.0),
                margin = EdgeValue(
                    left = 30.unitReal(),
                    right = 30.unitReal(),
                    top = 15.unitReal()
                )
            )
        )
}