package spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import spring.security.demo.Roles;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	@SuppressWarnings("deprecation")
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("kiran").password("manam").roles(Roles.EMPLOYEE.toString(),
						Roles.MANAGER.toString(), Roles.ADMIN.toString()))
				.withUser(users.username("priya").password("manam").roles(Roles.EMPLOYEE.toString(),
						Roles.MANAGER.toString()))
				.withUser(users.username("vihaan").password("manam").roles(Roles.EMPLOYEE.toString()));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole(Roles.EMPLOYEE.toString()).antMatchers("/leaders/**")
				.hasRole(Roles.MANAGER.toString()).antMatchers("/systems/**").hasRole(Roles.ADMIN.toString()).and()
				.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage("/accessDenied");

	}

}