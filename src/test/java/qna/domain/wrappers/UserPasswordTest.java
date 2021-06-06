package qna.domain.wrappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserPasswordTest {

    @Test
    void 비밀번호_생성() {
        UserPassword userPassword = new UserPassword("password");
        assertThat(userPassword).isEqualTo(new UserPassword("password"));
    }

    @Test
    void 비밀번호_길이가_20_초과_하는_경우_에러_발생() {
        String userId ="passwordpasswordpassword";
        assertThatThrownBy(() -> new UserPassword(userId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 가능한 길이는 20자 이하만 입력 가능합니다.");
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void 비밀번호가_null_이나_비어있는_문자열이_입력_하는_경우_에러_발생(String password) {
        assertThatThrownBy(() -> new UserPassword(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 입력되지 않았습니다.");
    }
}