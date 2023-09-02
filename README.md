#[AuthConfig] class is reposible for recieving login requests and validate/Authenticate user details and generate JWT tokens using [JwtHelper] class methods.
#[JwtAuthenticationEntryPoint] is responsible for handling exception when user gives wrong credentials.
#[JwtAuthenticationfilter] class implements (OncePerrequestFilter) and provides implementatoion for doFilterInternal() , recieves the JWT token from clients and process the token 
       *request.getHeader("Authorization") //gets the Header from taken
