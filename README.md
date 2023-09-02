#[AuthConfig] class is reposible for recieving login requests and validate/Authenticate user details and generate JWT tokens using [JwtHelper] class methods.
#[JwtAuthenticationEntryPoint] is responsible for handling exception when user gives wrong credentials.
#[JwtAuthenticationfilter] class implements (OncePerrequestFilter) and provides implementatoion for doFilterInternal() , recieves the JWT token from clients and will process the token 
       *request.getHeader("Authorization") //gets the Header from taken
       *to get User name from token we should extract it by using 1.startsWith("Bearer") and should use getUsername(token) from jwt class passing token from {1}.
       *to retrieve the currently authenticated principal(username) is via a static call to the SecurityContextHolder (Security ContextHolder.getContext().getAuthentication()) and if not currently                     authenticated principal , and if username is not null then proceed .
       *to retrieve user details we should use loadUserByUsername(username) from userDetailsService class 
       *to validate token and uerDetails we should call validateToken() from jwtHelper class
       *if it is valid validate username and password using Creating an innstance(UPA) of 2.UsernamePaswwordAuthenticationToken and passing (Object principal, Object credentials, Collection<? 	            extends GrantedAuthority> authorities)/(userdetils,null,userDetails.getAuthorities())
			 *to convert request from HttpServletRequest(OLD way of storing and passing a request from java6) to WebAuthenticationDetailsSource(New way of storing and passing a request from spring)  we 
				should use buildDetails(request) from  WebAuthenticationDetailsSource [OPTIONAL STEP]
			 *to set new AUthentication details in SecurityContext we should call SecurityContextHolder.getContext().setAuthentication(authentication{2})
			 * The process of veryfying JWT token is done so now we need to use filterchain.doFilter(request,response) , Causes the next filter in the chain to be invoked.
		   	
		 		
       
       
