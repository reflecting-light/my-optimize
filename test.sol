solidity pragma >0.4.7 <= 0.9.0;

contract Opt {
  uint x ;

  function cheap () external pure returns (uint) {
    uint y = x;
    for(uint i = 0; i < 3; i++ ){
      y++;
    }
    x = y
    return x;
  }

  function expe () external pure returns (uint) {

    for(uint i = 0; i < 3; i++ ){
      x++ ;
    }
    return x;
  }
}



// 不要使用这个合约，其中包含一个 bug。
contract Fund {
    /// 合约中 |ether| 分成的映射。
    mapping(address => uint) shares;
    /// 提取你的分成。
    function withdraw() public {
        if (msg.sender.send(shares[msg.sender]))
            shares[msg.sender] = 0;
    }
}