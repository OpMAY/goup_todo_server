'use strict';

async function apiSample(email, password) {
    function apiFetch(email, password) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", 'application/json');
        myHeaders.append("Content-Api", tokenGenerator(8));

        let raw = JSON.stringify({
            email,
            password
        });

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
        };
        const response = fetch(`/auth/login`, requestOptions);
        return response.then(res => res.json());
    }

    let result;
    try {
        result = await apiFetch(email, password);
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function apiFileUpload(file) {
    function apiFetch(file) {
        const formData = new FormData();
        formData.append('file', file);
        let requestOptions = {
            method: 'POST',
            body: formData,
        };
        const response = fetch(`/file/upload`, requestOptions);
        return response.then(res => res.json());
    }

    let result;
    try {
        result = await apiFetch(file);
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function getKakaoKey() {
    function apigetKakaoKey(email, password) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", 'application/json');
        myHeaders.append("Content-Api", tokenGenerator(8));

        let requestOptions = {
            method: 'GET',
            headers: myHeaders,
        };
        const response = fetch(`/api/sns`, requestOptions);
        return response.then(res => res.json());
    }

    let result;
    try {
        result = await apigetKakaoKey();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function updateBrand(no, brand) {
    function apiUpdateBrand(no, brand) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", 'application/json');
        myHeaders.append("Content-Api", tokenGenerator(8));

        let requestOptions = {
            method: 'PUT',
            headers: myHeaders,
            body: JSON.stringify(brand)
        };
        const response = fetch(`/api/kream/admin/brand/${no}`, requestOptions)
        return response.then(res => res.json())
    }

    let result;
    try {
        result = apiUpdateBrand(no, brand);
        return result;
    } catch (error) {
        console.log(error)
    }
}

async function makeBrand(brand) {
    function apiMakeBrand(brand) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", 'application/json');
        myHeaders.append("Content-Api", tokenGenerator(8));

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(brand)
        };
        const response = fetch(`/api/kream/admin/brand/`, requestOptions)
        return response.then(res => res.json())
    }

    let result;
    try {
        result = apiMakeBrand(brand);
        return result;
    } catch (error) {
        console.log(error)
    }
}

async function deleteBrand(no) {
    function apiDeleteBrand(no) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", 'application/json');
        myHeaders.append("Content-Api", tokenGenerator(8));

        let requestOptions = {
            method: 'DELETE',
            headers: myHeaders,
        };
        const response = fetch(`/api/kream/admin/brand/${no}`, requestOptions)
        return response.then(res => res.json())
    }

    let result;
    try {
        result = apiDeleteBrand(no);
        return result;
    } catch (error) {
        console.log(error)
    }
}