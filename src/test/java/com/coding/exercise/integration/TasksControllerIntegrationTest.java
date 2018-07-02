package com.coding.exercise.integration;

import com.coding.exercise.model.BalanceTestResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TasksControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBracket() {
        ResponseEntity<BalanceTestResult> responseEntity = this.restTemplate.
                getForEntity("/tasks/validateBrackets?input={}", BalanceTestResult.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getInput()).isEqualTo("{}");
        assertThat(responseEntity.getBody().isIsBalanced()).isTrue();
    }

}
