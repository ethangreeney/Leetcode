#include<iostream>

using namespace std;

long long fact(long long n){
    if(!n){
        return 1;
    }

    return((long long)n*fact(n-1));
}

int main(){
    for(long long i = 0; i < 100000; i++) {
        cout << fact((long long)i) << endl;
    }
    return 0;
}
