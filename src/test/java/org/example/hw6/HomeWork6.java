package org.example.hw6;

/** AutoWebUI. HomeWork-6
 *
 * @author Pavel Pulyk
 * @version 0.1 02.04.2022
 */

import org.example.hw6.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HomeWork6 extends BaseTestHW6 {

    @Test
    @DisplayName("Авторизация нового клиента в интернет-магазине")
    void authNewClientInOnlineStore() {
        new MainPage(webDriver)
                .auth()
                .basicData()
                .yourAddress()
                .yourPassword()
                .quit();
    }

    @Test
    @DisplayName("Проверка входа и выхода клиента в личный кабинет.")
    void loginToClientsPersonalAccount() {
        new MainPage(webDriver)
                .login(EMAIL, PASSWORD)
                .logout()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Вход в личный кабинет по неправильному паролю.")
    void incorrectPassword() {
        new MainPage(webDriver)
                .login(EMAIL, "incorrectPassword")
                .checkErrorIsVisible("Неправильно заполнены поле E-Mail и/или пароль!");
    }

    @Test
    @DisplayName("Проверка работы кнопки соцсети VK в хедере сайта")
    void checkButtonNetworkSocialVK() {
        new MainPage(webDriver)
                .login(EMAIL, PASSWORD)
                .checkButtonNetworkSocialVK();
    }
}