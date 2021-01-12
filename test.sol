pragma solidity >0.4.7 <= 0.9.0;

contract Opt {
  uint x ;

  function cheap () external returns (uint) {
    uint y = x;
    for(uint i = 0; i < 3; i++ ){
      y++;
    }

    return y;
  }

  function expe () external returns (uint) {

    for(uint i = 0; i < 3; i++ ){
      x++ ;
    }
    return x;
  }
}


