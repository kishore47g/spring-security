#[AuthConfig] class is reposible for recieving login requests and validate/Authenticate user details and generate JWT tokens using [JwtHelper] class methods.


#[JwtAuthenticationEntryPoint] is responsible for handling exception when user gives wrong credentials.


#[JwtAuthenticationfilter] class implements (OncePerrequestFilter) and provides implementatoion for doFilterInternal() , recieves the JWT token from clients and will process the token 
       i.request.getHeader("Authorization") //gets the Header from taken
       ii.to get User name from token we should extract it by using 1.startsWith("Bearer") and should use getUsername(token) from jwt class passing token from {1}.
       iii.to retrieve the currently authenticated principal(username) is via a static call to the SecurityContextHolder (Security ContextHolder.getContext().getAuthentication())
       and if not currently authenticated principal , and if username is not null then proceed .
       iv.to retrieve user details we should use loadUserByUsername(username) from userDetailsService class 
       v.to validate token and uerDetails we should call validateToken() from jwtHelper class
       vi.if it is valid validate username and password using Creating an innstance(UPA) of 2.UsernamePaswwordAuthenticationToken and passing (Object principal, Object credentials, Collection<? 	 extends GrantedAuthority> authorities)/(userdetils,null,userDetails.getAuthorities())
       vii.to convert request from HttpServletRequest(OLD way of storing and passing a request from java6) to WebAuthenticationDetailsSource(New way of storing and passing a request from spring)  	we should use buildDetails(request) from  WebAuthenticationDetailsSource [OPTIONAL STEP]
       viii.to set new AUthentication details in SecurityContext we should call SecurityContextHolder.getContext().setAuthentication(authentication{2})
       ix. The process of veryfying JWT token is done so now we need to use filterchain.doFilter(request,response) , Causes the next filter in the chain to be invoked.

       
#[JwtHelper] has several methods suchas: 
	i.getUsernameFromToken(String token) returns getClaimFromToken(token,Claims::getSubject)
 	ii.getExpirationDateFromToken(String token) returns getClaimsFromToken(token,claims::getExpiration) 
 	iii.getClaimFromToken(token) from Function<CLaims , T> claimsResolver passed as argument returns Claims instance and we should return claimsResolver.apply(Claims)/applies the method that is 	sent along with parameters to the claims
  	iv.getAllClaimsFromToken(token) returns Jwts.parserBuilder().setSigningKey(Secret).build().parseClaimsJws(token).getBody() //gets all the claims from token and returns as Claims type.
   	v.generateToken(userDetails) creates a instance of Map<String , Object >/HashMap and returns goGenerateToken(mapinstance,userdetails.getUsername())
    	vi.doGenerateToken(Map<String,Object> claims ,String subject) returns Jwts.builder().setClaims(Claims).setSubjects(subject).setIssuedAt(new  	   		          		  a t         Date(System.currentTimeMillis()).setExpiration(new Date(System.currentTimeMillis()+JWT_Token_VALIDITY * 1000).signWith(SignatureAlgorithm.HS512 , secret).compact()
     	//builds an object/stream sets the claims,subject,issuedAt,setExpiration and signs with algo and key
       vii.validateToken(token,userdetails) extract username  from token and checks with userdetails.getUsername() and returns true if token not expired.




 
		 		
       
       
