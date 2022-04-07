package org.example.hw7;

/** AutoWebUI. HomeWork-7
 *
 * @author Pavel Pulyk
 * @version 0.1 07.04.2022
 */

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.hw7.pages.MainPageHW7;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.hw7.pojo.User;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HomeWork-7")
class HomeWork7 extends BaseTestHW7 {

    @Test
    @DisplayName("Авторизация нового клиента в интернет-магазине")
    @Severity(SeverityLevel.CRITICAL)
    void authNewClientInOnlineStore() {
        new MainPageHW7(webDriver)
                .auth()
                .basicData()
                .yourAddress()
                .yourPassword()
                .quit();
    }

    @Test
    @DisplayName("Проверка входа и выхода клиента в личный кабинет.")
    @Severity(SeverityLevel.BLOCKER)
    void loginToClientsPersonalAccount() {
        new MainPageHW7(webDriver)
            .login(user)
            .logout()
            .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Вход в личный кабинет по неправильному паролю.")
    @Severity(SeverityLevel.NORMAL)
    void incorrectPassword() {
        new MainPageHW7(webDriver)
                .login(EMAIL, "incorrectPassword")
                .checkErrorIsVisible("Неправильно заполнены поле E-Mail и/или пароль!");
    }

    @Test
    @DisplayName("Проверка работы кнопки соцсети VK в хедере сайта")
    @Severity(SeverityLevel.MINOR)
    void checkButtonNetworkSocialVK() {
        new MainPageHW7(webDriver)
                .login(user)
                .checkButtonNetworkSocialVK();
    }
}
