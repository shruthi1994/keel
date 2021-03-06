package com.netflix.spinnaker.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.netflix.spinnaker.keel.info.InstanceIdSupplier
import com.netflix.spinnaker.keel.sql.SqlLock
import com.netflix.spinnaker.keel.sql.SqlResourceRepository
import com.netflix.spinnaker.kork.sql.config.DefaultSqlConfiguration
import org.jooq.DSLContext
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import java.time.Clock

@Configuration
@ConditionalOnProperty("sql.enabled")
@Import(DefaultSqlConfiguration::class)
class SqlConfiguration {
  @Bean
  fun resourceRepository(
    jooq: DSLContext,
    objectMapper: ObjectMapper,
    clock: Clock,
    instanceIdSupplier: InstanceIdSupplier
  ) =
    SqlResourceRepository(jooq, objectMapper, clock, instanceIdSupplier)

  @Bean
  fun lock(
    jooq: DSLContext,
    clock: Clock
  ) =
    SqlLock(jooq, clock)
}
