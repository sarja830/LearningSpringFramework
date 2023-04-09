import React, { Suspense } from "react";
import { useRef, useState } from 'react'
import { Canvas, useFrame } from "@react-three/fiber";
import {
  Decal,
  Float,
  OrbitControls,
  Preload,
  useTexture,
} from "@react-three/drei";

import CanvasLoader from "../Loader";

const Ball = (props) => {
  const ref = useRef()
  const [decal] = useTexture([props.imgUrl]);
  const [hovered, hover] = useState(false)
  const [clicked, click] = useState(false)
  // useFrame((state, delta) => (ref.current.rotation.x += delta))
  return (
    <Float speed={1.75} rotationIntensity={1} floatIntensity={2}>
      <ambientLight intensity={0.25} />
      <directionalLight position={[0, 0, 0.05]} />
      <mesh 
       ref={ref}
       onClick={(event) => click(!clicked)}
       onPointerOver={(event) => hover(true)}
       onPointerOut={(event) => hover(false)}
       castShadow receiveShadow  
       scale={clicked ? 3.25 : 2.75}
       
       >
        <icosahedronGeometry args={[1, 1]} />
        <meshStandardMaterial
          color={hovered ? 'gold' : '#ff8c00'}
          
          polygonOffset
          polygonOffsetFactor={-5}
          flatShading
        />
        <Decal
          position={[0, 0, 1]}
          rotation={[2 * Math.PI, 0, 6.25]}
          scale={1}
          map={decal}
          flatShading
        />
      </mesh>
    </Float>
  );
};

const BallCanvas = ({ icon }) => {
  return (
    <Canvas
      frameloop='demand'
      dpr={[1, 2]}
      gl={{ preserveDrawingBuffer: true }}
    >
      <Suspense fallback={<CanvasLoader />}>
        <OrbitControls enableZoom={false} />
        <Ball imgUrl={icon} />
      </Suspense>

      <Preload all />
    </Canvas>
  );
};

export default BallCanvas;