package com.example.vaccinatetogether.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Account implements UserDetails {
	
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	@Id
	@Column(columnDefinition = "BINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID id;
	private @Column(unique=true) String username;
	private String password;
	@OneToMany(mappedBy="account", cascade = CascadeType.REMOVE)
	@OrderColumn()
	@JsonManagedReference
	private Set<AccountReward> accountRewards;
	private boolean enabled;
	private Date created_dt;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="accountDetails")
	@JsonManagedReference
	private AccountDetails accountDetails;
	
	public Account() {}
	
	public Account(UUID id, String username, String password, Set<AccountReward> accountRewards, boolean enabled,
			Date created_dt, AccountDetails accountDetails) {
		super();
		this.id = id;
		this.username = username;
		this.password = Account.getPasswordEncoder().encode(password);
		this.accountRewards = accountRewards;
		this.enabled = enabled;
		this.created_dt = created_dt;
		this.accountDetails = accountDetails;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Account.getPasswordEncoder().encode(password);
	}
	public Set<AccountReward> getAccountRewards() {
		return accountRewards;
	}
	public void setAccountRewards(Set<AccountReward> accountRewards) {
		this.accountRewards = accountRewards;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	public static PasswordEncoder getPasswordEncoder() {
		return PASSWORD_ENCODER;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", accountRewards="
				+ accountRewards + ", enabled=" + enabled + ", created_dt=" + created_dt + ", accountDetails="
				+ accountDetails + "]";
	}
}
