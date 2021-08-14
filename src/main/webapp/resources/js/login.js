
const login = async (e) => {
	e.preventDefault();
	let uname = document.getElementById('username').value;
	let pass = document.getElementById('password').value;
	

	let user = {
		username: uname,
		password: pass,
	};

	
		let req = await fetch('http://localhost:8080/RESProject1/api/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		if (req.status !== 200) {
		alert("Username or password are incorrect");
		return;
	}
	else {
		let res = await req.text();
		
		if (res.uRole == 'Manager') { 
		//if (res.uRole == 'Manager') { 
			location.href = 'resources/html/employee-dashboard.html';
		
      
		} else {
			location.href = 'resources/html/manager-dashboard.html';
			 
			//location.href = 'resources/html/manager-dashboard.html';
			
			
		}
		
	} 
	


}
document.getElementById('submit').addEventListener('click', login);

